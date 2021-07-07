package com.app.wcf.controllers;

import com.app.wcf.dao.StateRepository;
import com.app.wcf.entities.StateDetails;
import com.app.wcf.entities.StateSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class StateController {
    @Autowired
    StateRepository repository;

    @GetMapping("/")
    public String index() { return "index"; }

    @PostMapping("upload-csv-file")
    public String uploadCSV(@RequestParam("file")MultipartFile file, Model model) throws IOException {
        List<StateDetails> stateDetails = new ArrayList<>();
        List<StateSummary> stateSummaries = new ArrayList<>();

        int i = 0;
        repository.deleteAll();

        if (file.isEmpty()) {
            model.addAttribute("message", "Select a csv file for upload");
            model.addAttribute("status", false);

        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                // TODO read through csv file and insert each row into the database
                String line;
                reader.readLine();
                while((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");

                    String sbal = fields[7].replace("$", "");
                    double bal = Double.parseDouble(sbal);
//                    BigDecimal bal = new BigDecimal(sbal);
                    StateDetails states = new StateDetails(
                            fields[0],
                            fields[1],
                            fields[2],
                            fields[3],
                            fields[4],
                            fields[5],
                            fields[6],
                            bal
                    );

                    repository.save(states);
                    stateDetails.add(states);
                }

            } catch (Exception e) {
                model.addAttribute("message", "an error occured while processing file");
                model.addAttribute("status", "false");
            }
        }

        List<?> summaryList = repository.getStateSummary();
        File file1 = new File("summary.csv");
        if (!file1.exists())
            file1.createNewFile();

        FileWriter writer = new FileWriter(file1);
        writer.write("STATE," + "MIN BALANCE," + "MAX BALANCE," + "MEAN BALANCE," + "TOTAL BALANCE\n");
        for (int k = 0; k < summaryList.size(); k++){
            Object[] row = (Object[]) summaryList.get(k);
//            model.addAttribute()
//            String[] strings = Arrays.toString(row).replace("[", "").replace("]", "").split(", ");
            String[] fields = Arrays.toString(row).replace("[", "").replace("]", "").replace(" ", "").split(",");
            writer.write(String.format("%s, %s, %s, %s, %s\n", fields[0], fields[2], fields[3], fields[4], fields[1]));
            String s = fields[0];
            BigDecimal tb = new BigDecimal(fields[1]);
            BigDecimal mb = new BigDecimal(fields[2]);
            BigDecimal mab = new BigDecimal(fields[3]);
            BigDecimal meb = new BigDecimal(fields[4]);

            StateSummary stateSummary = new StateSummary(
                    s, tb, mb, mab, meb
            );

            stateSummaries.add(stateSummary);
        }
        writer.close();


        model.addAttribute("summary", stateSummaries);
        model.addAttribute("numberOfStates", String.format("%s States", stateSummaries.size()));
        System.out.println(file.getOriginalFilename());
        System.out.println(stateDetails.size());
        System.out.println(stateSummaries.size());
        System.out.println(i);
        //        model.addAttribute("stateDetails",   stateDetails);
        model.addAttribute("rows", String.format("%s Rows uploaded successfully", stateDetails.size()));
        model.addAttribute("status",     true);
        return "file-upload-status";
    }
}
