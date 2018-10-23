package net.mode;

import net.mode.NetNode;

public class Line {
    private NetNode form;
    private NetNode to;

    public Line(NetNode form, NetNode to) {
        this.form = form;
        this.to = to;
    }

    public NetNode getForm() {
        return form;
    }

    public NetNode getTo() {
        return to;
    }

    public void setForm(NetNode form) {
        this.form = form;
    }

    public void setTo(NetNode to) {
        this.to = to;
    }
}
