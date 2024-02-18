<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="by.sportliner.lk.core.model.Transaction" -->
<#-- @ftlvariable name="total" type="java.math.BigDecimal" -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sportliner LK. Ежедневный финансовый отчет поступления оплат.</title>
    <style>

        table {
            border-collapse: collapse;
            border: 1px solid #cbcbcb;
        }

        td {
            border: 1px solid #cbcbcb;
            padding: 4px;
            text-align: left;
            min-width: 75px;
        }

        thead tr {
            background: #efefef;
        }

        .right-align {
            text-align: right;
        }

    </style>
</head>
<body>
<div>

    <p>
        Ежедневный финансовый отчет поступления оплат.
    </p>

    <br/>

    <p>
        Общая сумма поступлений за текущий день: ${total}
    </p>

    <br/>

    <table>
        <thead>
        <tr>
            <td>ФИО родителей</td>
            <td>Контактный телефон</td>
            <td>Филиал</td>
            <td>Данные ребенка</td>
            <td>Номер счета</td>
            <td>Сумма счета</td>
        </tr>
        </thead>
        <tbody>
        <#list data as item>
            <tr>
                <td class="right-align">
                    ${item.child.parent.fullName}
                </td>
                <td class="right-align">
                    ${item.child.parent.phone}
                </td>
                <td class="right-align">
                    ${item.child.branchOffice.name}
                </td>
                <td class="right-align">
                    ${item.child.fullName}
                </td>
                <td class="right-align">
                    ${item.child.getFullInvoiceNumber()}
                </td>
                <td class="right-align">
                    ${item.getInvoiceAmount()}
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>
</body>
</html>
