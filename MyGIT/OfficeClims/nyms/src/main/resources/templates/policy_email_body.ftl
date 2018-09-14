<#list policies as policyKey>

<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns:m="http://schemas.microsoft.com/office/2004/12/omml"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1252">
</head>

<body lang=EN-US link=blue vlink=purple style='tab-interval:.5in'>



<table style="width: 617px;">
<tbody>
<tr style="height: 476px;">
<td style="text-align: center; height: 476px; width: 609px;"><br />
<table style="height: 46px; width: 589px;">
<tbody>
<tr>
<td style="width: 98px;">&nbsp;</td>
<td style="width: 391px; text-align: center;">else<span style="color: #ff0000;">co</span> Aviation Policy Signature Page</td>
<td style="width: 102px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 98px;">&nbsp;</td>
<td style="width: 391px; text-align: center;">&nbsp;</td>
<td style="width: 102px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 98px;">&nbsp;</td>
<td style="width: 391px; text-align: center;">&nbsp;</td>
<td style="width: 102px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 98px;">&nbsp;</td>
<td style="width: 391px; text-align: center;">&nbsp;</td>
<td style="width: 102px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 98px;">&nbsp;</td>
<td style="width: 391px;">
<table style="height: 18px; width: 432px;">
<tbody>
<tr>
<td style="width: 231px; text-align: right;">RISK</td>
<td style="width: 13px;">:</td>
<td style="width: 191px; text-align: left;">${policyKey.RISK}</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">ORIGINAL ASSURED</td>
<td style="width: 13px;">:</td>
<td style="width: 191px; text-align: left;">${policyKey.ORIGINALASSRED}</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">UNIQUE MARKET REFERENCE</td>
<td style="width: 13px;">:</td>
<td style="width: 191px; text-align: left;">${policyKey.UMR}</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">ELSECO REFERENCE</td>
<td style="width: 13px;">:</td>
<td style="width: 191px; text-align: left;">${policyKey.ELSECOREFERENCE}</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">&nbsp;</td>
<td style="width: 13px;">&nbsp;</td>
<td style="width: 191px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">&nbsp;</td>
<td style="width: 13px;">&nbsp;</td>
<td style="width: 191px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 231px; text-align: right;">&nbsp;</td>
<td style="width: 13px;">&nbsp;</td>
<td style="width: 191px; text-align: left;">&nbsp;</td>
</tr>
</tbody>
</table>
</td>
<td style="width: 102px;">&nbsp;</td>
</tr>
</tbody>
</table>
<p style="text-align: left;">&nbsp;</p>

<table style="height: 5px;" width="592">
<tbody>
<tr>
<td style="width: 67px;">&nbsp;Share Value</td>
<td style="width: 67px;">of</td>
<td style="width: 67px;">Line Size</td>
<td style="width: 67px;">line of&nbsp;</td>
<td style="width: 68px;">Currency</td>
<td style="width: 68px;">Total Premium</td>
<td style="width: 68px;">Member Name</td>
<td style="width: 68px;">&nbsp;</td>
</tr>
<#list policyKey.MEMBERS as member>
<tr>
<td style="width: 67px;">${member.SHAREVL}</td>
<td style="width: 67px;">of</td>
<td style="width: 67px;">${member.LINESIZE}</td>
<td style="width: 67px;">line of&nbsp;</td>
<td style="width: 68px;">${member.CURRENCY}</td>
<td style="width: 68px;">${member.TOTALPREMIUM}</td>
<td style="width: 68px;">${member.MEMBERNAME}</td>
<td style="width: 68px;">&nbsp;</td>
</tr>
</#list>
</tbody>
</table>
<p style="text-align: left;">&nbsp;</p>
</td>
</tr>
<tr style="height: 150px;">
<td style="text-align: right; height: 150px; width: 609px;">
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p style="text-align: center;">else<span style="color: #ff0000;">co</span> limited a Company Limited by Shares under the Companies Law, DIFC Law No.3 of 2006.<br />Address: Gate Village 8, Dubai International Financial Centre, PO Box: 506639, Dubai, UAE.&nbsp;&nbsp;</p>
</td>
</tr>

</tbody>
</table>


</body>
</html>

</#list>
