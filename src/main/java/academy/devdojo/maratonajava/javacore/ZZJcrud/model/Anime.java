package academy.devdojo.maratonajava.javacore.ZZJcrud.model;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class Anime {
    Integer id;
    String name;
    Integer episodes;
    Producer producer;
}
