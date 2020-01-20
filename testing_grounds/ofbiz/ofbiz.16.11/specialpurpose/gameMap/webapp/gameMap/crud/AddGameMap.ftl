<div class="screenlet-body">
  <form id="createGameMapEvent" method="post" action="<@ofbizUrl>createGameMapEvent</@ofbizUrl>">
    <input type="hidden" name="addGameMapFromFtl" value="Y"/>
    <fieldset>
      <div>
        <span class="label">${uiLabelMap.GameMapName}</span>
        <input type="text" name="name" id="name" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.GameMapDescription}</span>
        <input type="text" name="description" id="firstName" class='required' maxlength="500" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.GameMapHeight}</span>
        <input type="text" name="height" id="lastName" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.GameMapWidth}</span>
        <input type="text" name="width" id="comments" class='required' maxlength="20" />
      </div>
    </fieldset>
    <input type="submit" value="${uiLabelMap.CommonAdd}" />
  </form>
</div>