<#ftl output_format="HTML" />
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-Hant-TW">
<div class="content container">
    <form action="/home/search" method="POST" class="form-horizontal">
        <button type="submit" class="btn btn-info" formaction="<@spring.url "/home" />">
            查詢
        </button>
        <button type="submit" class="btn btn-info">呼叫coinDesk的API</button>
        <div>
            <#if (page?? && page.totalElements> 0 ) >
                <table>
                    <tr>
                        <th>chartName</th>
                        <th>檢視資料</th>
                    </tr>
                    <tbody>
                    <#list page.content as item>
                        <tr>
                            <td>${item.chartName!}</td>
                            <td>
                                <button type="button" class="btn btn-info"
                                        onclick="location.href='<@spring.url "/home/update/"+item.id />'">
                                    <i class="glyphicon glyphicon-edit"></i>
                                    檢視資料
                                </button>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            <#else>
                無資料，請點呼叫API匯入資料
            </#if>
        </div>
    </form>
</div>
</html>