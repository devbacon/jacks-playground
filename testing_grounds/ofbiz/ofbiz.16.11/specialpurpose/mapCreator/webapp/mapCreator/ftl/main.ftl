<p>Hello World! ${groovyVar}</p>
<form method="post" action="<@ofbizUrl>createGameMap</@ofbizUrl>" name="createGameMap">
    <input type="text" name="name" placeholder="Map Name"/>
    <input type="text" name="width" placeholder="Map Width in Squares"/>
    <input type="text" name="height" placeholder="Map Height in Squares"/>
    <button type="submit">Create</button>
</form>
<table>
    <thead>
        <tr>
            <td>Map Name</td>
            <td>Map Height</td>
            <td>Map Width</td>
        </tr>
    </thead>
    <tbody>
    <#list createdGameMaps as map>
        <tr>
            <td>${map.name}</td>
            <td>${map.height}</td>
            <td>${map.width}</td>
        </tr>
    </#list>
    </tbody>
</table>