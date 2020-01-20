 <div class="screenlet-body">
  <#if gameMapList?has_content>
    <table cellspacing=0 cellpadding=2 border=0 class="basic-table">
      <thead><tr>
        <th>${uiLabelMap.GameMapId}</th>
        <th>${uiLabelMap.GameMapName}</th>
        <th>${uiLabelMap.GameMapDescription}</th>
        <th>${uiLabelMap.GameMapHeight}</th>
        <th>${uiLabelMap.GameMapWidth}</th>
      </tr></thead>
      <tbody>
        <#list gameMapList as gameMap>
          <tr>
            <td>${gameMap.gameMapId}</td>
            <td>${gameMap.name?default("NA")}</td>
            <td>${gameMap.description?default("NA")}</td>
            <td>${gameMap.height?default("NA")}</td>
            <td>${gameMap.width?default("NA")}</td>
          </tr>
        </#list>
       </tbody>
    </table>
  </#if>
</div>