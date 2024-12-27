package Prac7;

import java.util.ArrayList;

public class VerbodeWoordenProces implements OpmaakProces{
    private ArrayList<String> VerbodeWoorden = new ArrayList<>();

    public void censureerWoord(String woord){
        this.VerbodeWoorden.add(woord);
    }

    @Override
    public String maakOp(String input){
        for (String woord : this.VerbodeWoorden) {
            input = input.replaceAll("(?i)" + woord, "****");
        }

        return input;
    }
}
