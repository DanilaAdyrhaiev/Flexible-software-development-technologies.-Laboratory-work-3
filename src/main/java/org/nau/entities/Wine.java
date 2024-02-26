package org.nau.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Wine {
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String brand;
    @NonNull
    private String country;
    @NonNull
    private LocalDate bottlingDate;
    @NonNull
    private String note;

    public int calculateAge(LocalDate currentDate) {
        return currentDate.getYear() - bottlingDate.getYear();
    }
}
