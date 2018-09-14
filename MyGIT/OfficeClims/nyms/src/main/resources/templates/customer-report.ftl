<!DOCTYPE html>
<html>
   <head>
      <style>
         #customers {
         font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
         border-collapse: collapse;
         width: 100%;
         }
         #customers td, #customers th {
         border: 1px solid #ddd;
         padding: 8px;
         }
         #customers tr:nth-child(even){background-color: #f2f2f2;}
         #customers tr:hover {background-color: #ddd;}
         #customers th {
         padding-top: 12px;
         padding-bottom: 12px;
         text-align: left;
         background-color: #33CAFF;
         color: white;
         }
      </style>
   </head>
   <body>
   	  <center><h3>${title}</h3></center>
      <table id="customers">
         <tr>
            <th>Name</th>
            <th>Contact</th>
            <th>Country</th>
         </tr>
         <#list companies as company>
         	<tr>
            	<td>${company.name} </td>
            	<td>${company.contact} </td>
            	<td>${company.country} </td>
         	</tr>
         </#list>
        
      </table>
   </body>
</html>