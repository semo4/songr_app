package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MyController {


    @GetMapping("/")
    public String getHome(){
        return "index.html";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/capitalize/{word}")
    public String getCapitalize(@PathVariable("word") String word, Model m){
        m.addAttribute("word", word.toUpperCase());
        return  "cap.html";
    }

    @GetMapping("/album")
    public String getAlbum(Model m){
        Album a1 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
        Album a2 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
        Album a3 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");

        List<Album> myAlbum = new ArrayList<>();
        myAlbum.add(a1);
        myAlbum.add(a2);
        myAlbum.add(a3);

        m.addAttribute("albums",myAlbum);

        return "albums.html";
    }




}
