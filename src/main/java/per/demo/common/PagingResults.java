package per.demo.common;

import java.util.List;

/**
 * PageResults
 *
 * @author Wilson
 * @date 18-5-7
 */
public class PagingResults<T> {
    private Long total;
    private Integer size;
    private Integer page;
    private List<T> resultList;

    public PagingResults(Long total, Integer size, Integer page, List<T> resultList) {
        this.total = total;
        this.size = size;
        this.page = page;
        this.resultList = resultList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
