package api.model.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Points {

    private int count;
    private int page;
    @SerializedName("total_pages")
    private int totalPages;
    private List<Point> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Point> getItems() {
        return items;
    }

    public void setItems(List<Point> items) {
        this.items = items;
    }

}
