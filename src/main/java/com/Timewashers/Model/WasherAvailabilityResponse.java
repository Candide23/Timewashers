package com.Timewashers.Model;

public class WasherAvailabilityResponse {

    private Long washerId;
    private boolean isWasherAvailable;
    private int minutesRemaining;

    public WasherAvailabilityResponse(int minutesRemaining, Long washerId, boolean isWasherAvailable) {
        this.washerId = washerId;
        this.isWasherAvailable = isWasherAvailable;
        this.minutesRemaining = minutesRemaining;
    }

    public int getMinutesRemaining() {
        return minutesRemaining;
    }

    public void setMinutesRemaining(int minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }

    public Long getWasherId() {
        return washerId;
    }

    public void setWasherId(Long washerId) {
        this.washerId = washerId;
    }

    public boolean isWasherAvailable() {
        return isWasherAvailable;
    }

    public void setWasherAvailable(boolean isWasherAvailable) {
        this.isWasherAvailable = isWasherAvailable;
    }
}








