package com.crackcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

@Document(indexName = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Text, fielddata = true), otherFields = { @InnerField(suffix = "verbatim", type = FieldType.Keyword) })
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = FieldType.Keyword)
    private String[] tags;
}
