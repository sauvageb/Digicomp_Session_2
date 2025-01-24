package com.training.demo.dto;

import com.training.demo.model.OperationDirection;

public class OperationDirectionChecked {
    private OperationDirection direction;
    private boolean checked;

    public OperationDirectionChecked(OperationDirection direction, boolean checked) {
        this.direction = direction;
        this.checked = checked;
    }

    public OperationDirection getDirection() {
        return direction;
    }

    public void setDirection(OperationDirection direction) {
        this.direction = direction;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
