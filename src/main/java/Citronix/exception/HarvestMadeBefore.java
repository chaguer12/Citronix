package Citronix.exception;

public class HarvestMadeBefore extends RuntimeException {
    public HarvestMadeBefore(String message){
        super(message);
    }
}
