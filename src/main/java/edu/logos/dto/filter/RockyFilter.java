package edu.logos.dto.filter;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RockyFilter {

    private String search;

    private int minValue;

    private int maxValue;

    private int pageSize;

    public String toString() {
        return this.getSearch();
    }
}
