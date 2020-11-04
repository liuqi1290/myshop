package com.test;

import com.liuqi.EsApplication;
import com.liuqi.es.pojo.ListNode;
import com.liuqi.es.pojo.Stu;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class esTest {
    @Autowired
    private ElasticsearchTemplate template;

    /**
     * 不建议使用Java 进行对索引管理，不会频繁进行对索引进行维护，使用templete 多用来进行对文档操作
     * 默认的shards  是5主分片每个对应一个副本分片，使用此方法无法对索引分片进行设置。
     */
    @Test
    public void createIndexStu() {

        Stu stu = new Stu();
        stu.setStuId(1002l);
        stu.setName("张三");
        stu.setAge(22);
        stu.setDesc("测试");
        stu.setMoney(2.55f);
        stu.setSign("liuqi");
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(stu).build();

        template.index(indexQuery);
    }

    @Test
    public void deleteIndexStu() {
        template.deleteIndex(Stu.class);
    }


    //——————————————————————————————————————————————文档操作_________________________________________

    @Test
    public void updateDocumentStu() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "lisi");
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.source(map);
        UpdateQuery updateQuery = new UpdateQueryBuilder().withClass(Stu.class).withId("1002").withIndexRequest(indexRequest).build();
        template.update(updateQuery);
    }


    @Test
    public void queryDocumentStu() {
        GetQuery getQuery = new GetQuery();
        getQuery.setId("1002");
        Stu stu = template.queryForObject(getQuery, Stu.class);
        System.out.println(stu.toString());
    }

    @Test
    public void deleteDocumentStu() {
        template.delete(Stu.class, "1001");
    }

    //——————————————————————————————————————————————search_________________________
    @Test
    public void searchDocumentStu() {
        PageRequest pageRequest = PageRequest.of(0, 1);
        SearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("desc", "测"))
                .withPageable(pageRequest)
                .build();
        AggregatedPage<Stu> stus = template.queryForPage(build, Stu.class);
        List<Stu> stuList = stus.getContent();
        for (Stu stu : stuList) {
            System.out.println(stu.toString());
        }
    }

    @Test
    public void highlightDocumentStu() {
        PageRequest pageRequest = PageRequest.of(0, 1);
        FieldSortBuilder sortBuilder = new FieldSortBuilder("age").order(SortOrder.ASC);
        SearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("desc", "测"))
                .withHighlightFields(new HighlightBuilder.Field("desc").preTags("<font color='red'>").postTags("</font>"))
                .withSort(sortBuilder)
                .withPageable(pageRequest)
                .build();
        AggregatedPage<Stu> stus = template.queryForPage(build, Stu.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                ArrayList<Stu> list = new ArrayList<>();
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    HighlightField highlightField = hit.getHighlightFields().get("desc");
                    String desc = highlightField.getFragments()[0].toString();
                    Object id = hit.getSourceAsMap().get("stuId");
                    hit.getSourceAsMap().get("name");
                    hit.getSourceAsMap().get("sign");
                    hit.getSourceAsMap().get("age");
                    hit.getSourceAsMap().get("desc");
                    hit.getSourceAsMap().get("money");
                    Stu stu = new Stu();
                    stu.setDesc(desc);
                    stu.setStuId(Long.valueOf(id.toString()));
                    list.add(stu);
                }
                if (list.size() > 0) {
                    return new AggregatedPageImpl<>((List<T>) list);
                }
                return null;
            }
        });
        List<Stu> stuList = stus.getContent();
        for (Stu stu : stuList) {
            System.out.println(stu.toString());
        }
    }


    @Test
    public void text() {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.print();
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        System.out.println();
        pre.print();
    }

    @Test
    public void reverseList() {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.print();

        ListNode reserv = reserv(head);
        reserv.print();
    }

    public ListNode reserv(ListNode head){
        if(head==null || head.next==null){
          return  head;
        }
        ListNode listNode = reserv(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;
    }
}
