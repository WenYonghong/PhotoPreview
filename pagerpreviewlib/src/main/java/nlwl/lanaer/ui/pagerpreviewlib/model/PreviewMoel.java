package nlwl.lanaer.ui.pagerpreviewlib.model;

import java.io.Serializable;

public class PreviewMoel implements Serializable {
    private String path;

    public PreviewMoel(String path) {
        this.path = path;
    }

    public PreviewMoel() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
