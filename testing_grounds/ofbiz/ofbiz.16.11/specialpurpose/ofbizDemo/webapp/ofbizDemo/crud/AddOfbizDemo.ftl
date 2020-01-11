<#--  <div class="screenlet-body">
  <form id="createOfbizDemoEvent" method="post" action="<@ofbizUrl>createOfbizDemoEvent</@ofbizUrl>">
    <input type="hidden" name="addOfbizDemoFromFtl" value="Y"/>
    <fieldset>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoType}</span>
        <select name="ofbizDemoTypeId" class='required'>
          <#list ofbizDemoTypes as demoType>
            <option value='${demoType.ofbizDemoTypeId}'>${demoType.description}</option>
          </#list>
        </select>*
      </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoFirstName}</span>
        <input type="text" name="firstName" id="firstName" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoLastName}</span>
        <input type="text" name="lastName" id="lastName" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoComment}</span>
        <input type="text" name="comments" id="comments" class='inputBox' size="60" maxlength="255" />
      </div>
    </fieldset>
    <input type="submit" value="${uiLabelMap.CommonAdd}" />
  </form>
</div>  -->

<form method="post" action="<@ofbizUrl>createOfbizDemoEventFtl</@ofbizUrl>" name="createOfbizDemoEvent" class="form-horizontal">
  <div class="control-group">
    <label class="control-label" for="ofbizDemoTypeId">${uiLabelMap.OfbizDemoType}</label>
    <div class="controls">
      <select id="ofbizDemoTypeId" name="ofbizDemoTypeId">
        <#list ofbizDemoTypes as demoType>
          <option value='${demoType.ofbizDemoTypeId}'>${demoType.description}</option>
        </#list>
      </select>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="firstName">${uiLabelMap.OfbizDemoFirstName}</label>
    <div class="controls">
      <input type="text" id="firstName" name="firstName" required>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="lastName">${uiLabelMap.OfbizDemoLastName}</label>
    <div class="controls">
      <input type="text" id="lastName" name="lastName" required>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="comments">${uiLabelMap.OfbizDemoComment}</label>
    <div class="controls">
      <input type="text" id="comments" name="comments">
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn">${uiLabelMap.CommonAdd}</button>
    </div>
  </div>
</form>