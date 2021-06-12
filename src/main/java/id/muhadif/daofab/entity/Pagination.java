package id.muhadif.daofab.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author muhadif
 * @create 13/06/21 00.37
 */
public class Pagination<T> {
    private int page;
    private int offset;
    private int size;
    private int startFrom;
    private int endOn;
    private List<T> product;

    public Pagination(int page, int offset, int size) {
        this.page = page - 1;
        this.offset = offset;
        this.size = size;
        this.startFrom = offset * (page - 1);
        endOn = startFrom + offset;
        while (endOn > size){
            endOn--;
        }
    }

    public List<Integer> getAvailablePages(){
        List<Integer> pages = new ArrayList<>();
         page = 1;
        while ((page-1) * offset <= size ){
            page++;
            pages.add(page-1);
        }
        return pages;
    }

    public int getStartFrom(){
        return startFrom;
    }

    public int getEndOn(){
        return endOn;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getProduct() {
        return product;
    }

    public void setProduct(List<T> product) {
        this.product = product;
    }
}
