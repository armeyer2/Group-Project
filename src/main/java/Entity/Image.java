package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Image {

    private String msg;
    private String imgSrc;

    @JsonIgnore
    private Set<String> imageSet = new HashSet<String>(Arrays.asList(msg, imgSrc));

    public Set<String> getImageSet() {
        return imageSet;
    }
}
