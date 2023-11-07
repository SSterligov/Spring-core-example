package org.example;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckContact {
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
    public final Pattern VALID_FIO_REGEX = Pattern.compile("^[a-zA-Zа-яА-Я]+\\s[a-zA-Zа-яА-Я]+(\\s[a-zA-Zа-яА-Я]+)?$");

    public CheckContactResult checkContact(String contact) {

        boolean fioCheck = false;
        boolean phoneCheck = false;
        boolean emailCheck = false;

        CheckContactResult checkContactResult = new CheckContactResult();
        String checkingFio = null;
        String checkingPhoneNumber = null;
        String checkingEmail = null;

        String[] arr = contact.split("; ");
        for(int i=0 ; i<arr.length; i++) {
            if(i==2) {
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(arr[2].trim());
                emailCheck = matcher.matches();
                if(emailCheck) {
                    checkingEmail = arr[2].trim();
                }else {
                    checkContactResult.getErrorMessage().append("\n").append("Не верный формат email");
                }
            }
            if(i==1) {
                Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(arr[1].trim());
                phoneCheck = matcher.matches();
                if(phoneCheck) {
                    checkingPhoneNumber = arr[1].trim();
                }else {
                    checkContactResult.getErrorMessage().append("\n").append("Не верный формат номера телефона");
                }
            }
            if(i==0) {
                Matcher matcher = VALID_FIO_REGEX.matcher(arr[0].trim());
                fioCheck = matcher.matches();
                if(fioCheck) {
                    checkingFio = arr[0].trim();
                }else {
                    checkContactResult.getErrorMessage().append("\n").append("Не верный формат ФИО");
                }
            }
        }
        if(fioCheck && phoneCheck && emailCheck) {
            checkContactResult.setCheckingContact(new Contact(checkingFio, checkingPhoneNumber, checkingEmail));
        }
        return checkContactResult;
    }



}
