<#ftl output_format="HTML" />
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-Hant-TW">
<div class="content container">
    <form action="/home" method="GET" class="form-horizontal">
        <button type="submit" class="btn btn-info">完成按此返回</button>
        <label></label>
        <div>
            <label>chartName</label>
            <@spring.formInput path="main.chartName" attributes="disabled='disabled' size='100'"/>
        </div>
        <div>
            <label class="">disclaimer</label>
            <@spring.formInput path="main.disclaimer" attributes="disabled='disabled' size='100'"/>
        </div>
        <div>
            <label>updated</label>
            <@spring.formInput path="main.updated" attributes="disabled='disabled' size='100'"/>
        </div>
        <div>
            <label>updatedISO</label>
            <@spring.formInput path="main.updatedISO" attributes="disabled='disabled' size='100'"/>
        </div>
        <div>
            <label>updateDuk</label>
            <@spring.formInput path="main.updateDuk" attributes="disabled='disabled' size='100'"/>
        </div>
        <table>
            <tr>
                <th>
                    code
                </th>
                <th>
                    symbol
                </th>
                <th>
                    rate
                </th>
                <th>
                    description
                </th>
                <th>
                    rateFloat
                </th>
            </tr>
            <tbody>
            <#list main.children as item>
                <tr>
                    <td>${item.code!}</td>
                    <td>${item.symbol!}</td>
                    <td>${item.rate!}</td>
                    <td>${item.description!}</td>
                    <td>${item.rateFloat!}</td>

                </tr>
            </#list>
            </tbody>
        </table>
    </form>
</div>
</html>