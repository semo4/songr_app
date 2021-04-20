package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MyController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;


//    @GetMapping("/")
//    public String getHome(){
//        return "index.html";
//    }

//    @ResponseBody
//    @GetMapping("/hello")
//    public String getHello(){
//        return "Hello World";
//    }
//
//    @GetMapping("/capitalize/{word}")
//    public String getCapitalize(@PathVariable("word") String word, Model m){
//        m.addAttribute("word", word.toUpperCase());
//        return  "cap.html";
//    }
//
//    @GetMapping("/album")
//    public String getAlbum(Model m){
//        Album a1 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
//        Album a2 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
//        Album a3 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
//
//        List<Album> myAlbum = new ArrayList<>();
//        myAlbum.add(a1);
//        myAlbum.add(a2);
//        myAlbum.add(a3);
//
//        m.addAttribute("albums",myAlbum);
//
//        return "albums.html";
//    }


    @GetMapping("/")
    public String getAllAlbum(Model m){
        m.addAttribute("albums" ,albumRepository.findAll());
        return "index.html";
    }
    @GetMapping("/albums")
    public String getAllAlbums(Model m){
        m.addAttribute("albums" ,albumRepository.findAll());
        return "albums.html";
    }

    @GetMapping("/addAlbum")
    public String getAddAlbumView(){
        return "addAlbum.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                   @RequestParam(value= "artist") String artist,
                                   @RequestParam(value="songCount") int songCount,
                                   @RequestParam(value="length") int length,
                                   @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return  new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}")
    public String getAlbumById(@PathVariable int id, Model m){
        Album album =albumRepository.findAlbumById(id);
        List<Song> song = songRepository.findSongByAlbumId(id);
        m.addAttribute("album", album);
        m.addAttribute("songs",song);
        return "singleAlbum.html";
    }

    @GetMapping("/addsongs/{id}")
    public String getAddSongView(@PathVariable int id, Model m){
        m.addAttribute("albumId", id);
        return "addsong";
    }








}
