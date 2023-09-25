package com.Timewashers.Model;

public class WasherAvailabilityResponse {

    private int minutesRemaining;

    public WasherAvailabilityResponse(int minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }

    public int getMinutesRemaining() {
        return minutesRemaining;
    }

    public void setMinutesRemaining(int minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }
}








