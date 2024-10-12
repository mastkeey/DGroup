package ru.mastkey.dgroup.model.request;

import lombok.Data;

@Data
public class FeedbackRequest {
    private String comment;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return "Заявка на обратную связь: \n" +
                "Номер телефона: " + (phoneNumber != null ? phoneNumber : "Не указан") + "\n" +
                "Электронная почта: " + (email != null ? email : "Не указана") + "\n" +
                "Комментарий: " + (comment != null ? comment : "Не указан") + "\n";

    }
}
