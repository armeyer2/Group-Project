package Entity;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
        ;

public class ImageParserTest {



    HTMLImageParser imageParser = new HTMLImageParser();
    String searchParameter;
    String resultOutput;


   @Test
    void getImageSuccess() {
       searchParameter = "strawberry";
       resultOutput = imageParser.ImageSearch(searchParameter);
       assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF7EHfslQHj393Ro_JA52iDZ7xPYhKKM9c1QuRDlmuETNomzP_lw5kyEI", resultOutput);

   }


    @Test
    void getMultipleImagesSuccess(){
       searchParameter = "potato";
       List<String> imageList = imageParser.MultipleImageSearch(searchParameter);
       //assertEquals("[https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEPMlqm-rPgl2WWZQcvv94h1UNhUjw7CHO81vZ1fPyhlqra5iWLFH9qRy_, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4bXmk3m6bgPOefd6oiSeQfAiIgtODrffCz5D818iL_RDj-uTDf4S8Z5Q, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2JygxY5pJ2A4bCM61VZD7Ig8aBeq5x42SIt1smnroh4l7UHPUr_N4FO7G, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9S2bydk7rvfSSDsA6-LbBFFQfenS7wU1vOcFW1F8R98VsFDfitHoI5Lb7, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn2id42x8pX99XfFbeKUDmlCUYHQg5QxpvIIvzaqFfZ5M7uxQJg1TZ_g, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwhvrNsJ83ZrKCRp2jx7cGGToYocgVtcKxZIVzO7m-KfK7NUoqJPszxGK_, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU3Nrpxyrx_x4FI6kIUI1MM-zo5zwnrNZT5XeS8r7xvTjoxTen5Fzpe6vc, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHuNqCnLhHHf1Nlr5ch4hjuywbdmCAsQYhErxA7PS8ZHLvH0p6iaqsMvuL, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQImTQt9-Hm0BqyAR_oiAyYa-lApFT0Ksp5PyeIVNpPsPBlBd7UT-su0S8L, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNCR7wROVePEI6BgcMoP1rOG2H65JbNfbl46d3MBM2daItff2wIJU_DA, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYbfm6jpF10B_pn-dPN-ij1wbDMsh9FVhp_4r-a6zVNG0inS2fjJr5VcJn, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkXMED8vEH-JzkVRULra1ZWqlZSAOocIvqiKyMLBJclRJmNeRFg5f-V9NB, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbi4YXXXvGbAToJ4pgg5i_LC8Q1-owtwLmWqviZTysp9vC8lqGaviG8NuX, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVY0sJzcPtOEw2wQwL65wcEPs0m54emiXkBlm2zpBpTv78RgLHMIx7KwWJBw, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbig7zr9Uh6ZfgzvcRRmONL8JPMRaMtXsJmAg-uE3iE-251tB2vWgiHGE, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1hFNAToZKQe1LCL75vFrRGQqRElcOdKFX3YfsdubevD95DSN7Ah46Zj4, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc0wJoBi_ZKbRO52EqWQwwFkqfSy3WTbZTuejGT0Sw9HkxfgO8EE7KcA, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt6zVH3ls5JJmP8qqEOVTKQCwIcNJ8Ivv_tZ5gN3wv13Pi3TFqBOVY4saT, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoECXHBLbSfzGw-XDDyrWU3E05Zb7SvlKgnkIJHJvqbh_q3E_rZF3EPb-M, https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTy1QkzRNGn4f5Sk0to33686E3XdbNxKXSBjL01FGTWBpOQcsKulKtRnnen]", imageList.toString());
        assertEquals(20, imageList.size());
    }

}
