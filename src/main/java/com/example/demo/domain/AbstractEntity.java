package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.tist.bean.json.View;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 所有Entity的基礎型態
 *
 * @author Franky
 */
@ApiModel(description = "基礎型態")
@MappedSuperclass
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//避免觸發proxy的lazy fetch產生錯誤
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 2698812789010477485L;

    /**
     * 主鍵
     */
    @Id
    @Column(name = "id_", nullable = false, length = 32)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    /**
     * 建立者帳號
     */
    @ApiModelProperty("建立者帳號")
    @Column(name = "create_user_id_", length = 32)
    private String createUserId;

    /**
     * 建立時間
     */
    @ApiModelProperty("建立時間")
    @Column(name = "create_time_")
    private LocalDateTime createTime;

    /**
     * 修改者帳號
     */
    @ApiModelProperty("修改者帳號")
    @Column(name = "modify_user_id_", length = 32)
    private String modifyUserId;

    /**
     * 修改時間
     */
    @ApiModelProperty("修改時間")
    @JsonView(View.Detail.class)
    @Column(name = "modify_time_")
    private LocalDateTime modifyTime;

    /**
     * 是否停用
     */
    @ApiModelProperty("是否停用")
    @JsonView(View.Summary.class)
    @Column(name = "disabled_")
    private Boolean disabled;

    /**
     * 備註
     */
    @ApiModelProperty("備註")
    @JsonView(View.Detail.class)
    @Column(name = "note_", length = 4000)
    private String note;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @JsonView(View.Summary.class)
    @Column(name = "sort_")
    private Integer sort;


}
