<#ftl output_format="HTML" />
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-Hant-TW">
<div class="content container">
    <form action="/home" method="GET" class="form-horizontal">
        <button type="submit" class="btn btn-info">完成按此返回</button>
        <@spring.formHiddenInput path="main.id"/>
        <div>
            <label>chartName</label>
            <@spring.formInput path="main.chartName" attributes=" size='50'"/>
        </div>
        <div>
            <label>chineseName</label>
            <@spring.formInput path="main.chineseName" attributes=" size='50'"/>
        </div>
        <div>
            <label class="">disclaimer</label>
            <@spring.formInput path="main.disclaimer" attributes="disabled='disabled' size='100'"/>
        </div>
        <div>
            <label>updated</label>
            <@spring.formInput path="main.updated" attributes=" size='50'"/>
        </div>
        <div>
            <label>updatedISO</label>
            <@spring.formInput path="main.updatedISO" attributes=" size='50'"/>
        </div>
        <div>
            <label>updateDuk</label>
            <@spring.formInput path="main.updateDuk" attributes=" size='50'"/>
        </div>
        <div>
            <label>code</label>
            <@spring.formHiddenInput path="main.children[0].id" />
            <@spring.formInput path="main.children[0].code" attributes=" size='50'"/>
        </div>
        <div>
            <label>symbol</label>
            <@spring.formInput path="main.children[0].symbol" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rate</label>
            <@spring.formInput path="main.children[0].rate" attributes=" size='50'"/>
        </div>
        <div>
            <label>description</label>
            <@spring.formInput path="main.children[0].description" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rateFloat</label>
            <@spring.formInput path="main.children[0].rateFloat" attributes="disabled='disabled' size='50'"/>
        </div>

        <div>
            <label>code</label>
            <@spring.formHiddenInput path="main.children[1].id" />
            <@spring.formInput path="main.children[1].code" attributes=" size='50'"/>
        </div>
        <div>
            <label>symbol</label>
            <@spring.formInput path="main.children[1].symbol" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rate</label>
            <@spring.formInput path="main.children[1].rate" attributes=" size='50'"/>
        </div>
        <div>
            <label>description</label>
            <@spring.formInput path="main.children[1].description" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rateFloat</label>
            <@spring.formInput path="main.children[1].rateFloat" attributes="disabled='disabled' size='50'"/>
        </div>

        <div>
            <label>code</label>
            <@spring.formHiddenInput path="main.children[2].id" />
            <@spring.formInput path="main.children[2].code" attributes=" size='50'"/>
        </div>
        <div>
            <label>symbol</label>
            <@spring.formInput path="main.children[2].symbol" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rate</label>
            <@spring.formInput path="main.children[2].rate" attributes=" size='50'"/>
        </div>
        <div>
            <label>description</label>
            <@spring.formInput path="main.children[2].description" attributes="disabled='disabled' size='50'"/>
        </div>
        <div>
            <label>rateFloat</label>
            <@spring.formInput path="main.children[2].rateFloat" attributes="disabled='disabled' size='50'"/>
        </div>

        <button type="submit" class="btn btn-info"
                formaction='<@spring.url "/home/save" />'>
            修改內容
        </button>
    </form>
</div>
</html>