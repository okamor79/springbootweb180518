package edu.logos.dto.filter;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RockyFilter {

    private String search;

    private int minValue = 2000;

    private int maxValue = 200000;

    private int pageSize = 10;

    public String toString() {
        return this.getSearch();
    }
}
