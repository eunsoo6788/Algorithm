import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Video340213 {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        var videoDuration = getDuration(video_len);
        var posDuration = getDuration(pos);
        var opStartDuration = getDuration(op_start);
        var opEndDuration = getDuration(op_end);


        if (isSkipOpening(posDuration, opStartDuration, opEndDuration)) {
            posDuration = opEndDuration;
        }

        for (String command : commands) {
            switch (command) {
                case "next": posDuration = next(videoDuration, posDuration, opStartDuration, opEndDuration); break;
                case "prev": posDuration = prev(posDuration, opStartDuration, opEndDuration); break;
            }

            if (posDuration.equals(opEndDuration)) {
                break;
            }
        }

        System.out.println(getAnswer(posDuration));

        return getAnswer(posDuration);
    }

    private String getAnswer(Duration posDuration) {

        var minuteStr = "";
        var secondStr = "";

        var totalSeconds = posDuration.get(ChronoUnit.SECONDS);
        var seconds = totalSeconds % 60;
        var minutes = totalSeconds / 60;

        if (minutes >= 10) {
            minuteStr = String.valueOf(minutes);
        }

        if (minutes <= 10) {
            minuteStr = "0" + minutes;
        }

        if (minutes == 0) {
            minuteStr = "00";
        }

        if (seconds >= 10) {
            secondStr = String.valueOf(seconds);
        }

        if (seconds < 10) {
            secondStr = "0" + seconds;
        }


        if (seconds == 0) {
            secondStr = "00";
        }


        return minuteStr + ":" + secondStr;

    }


    private Duration getDuration(String timeStr) {

        var timeArr = timeStr.split(":");

        var seconds = Integer.parseInt(timeArr[1]);
        var minutes = Integer.parseInt(timeArr[0]);

        return Duration.ofSeconds(minutes * 60L + seconds);
    }


    private Duration next(Duration videoDuration, Duration posDuration, Duration opStartDuration, Duration opEndDuration){

        posDuration = posDuration.plusSeconds(10);

        if (videoDuration.minus(posDuration).isNegative()) {
            return videoDuration;
        }


        if (isSkipOpening(posDuration, opStartDuration, opEndDuration)) {
            return opEndDuration;
        }

        return posDuration;
    }


    private Duration prev(Duration posDuration, Duration opStartDuration, Duration opEndDuration){

        posDuration = posDuration.minusSeconds(10);

        if (posDuration.isNegative()) {
            return Duration.ofSeconds(0);
        }

        if (isSkipOpening(posDuration, opStartDuration, opEndDuration)) {
            return opEndDuration;
        }


        return posDuration;
    }


    private boolean isSkipOpening(Duration posDuration, Duration opStartDuration, Duration opEndDuration) {
        return posDuration.compareTo(opStartDuration) > 0 && posDuration.compareTo(opEndDuration) < 0;
    }

}