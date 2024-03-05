<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="by.sportliner.lk.core.service.email.UpdatedInvoicesData" -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sportliner LK. Финансовый отчет по итогам автоматического обновления счетов</title>
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
     Финансовый отчет после автоматического обновления счетов
    </p>

    <br/>

    <p>
        Общая сумма выставленных/обновленных счетов: ${data.totalPrice} BYN
    </p>

    <br/>

    <p>
        ООО "Спортлинер":
    </p>

    <br/>

    <table>
        <thead>
        <tr>
            <td>Филиал</td>
            <td>Общая сумма выставленных счетов</td>
        </tr>
        </thead>
        <tbody>

        <#list data.getSportlinerTransactionsByBranchOffice() as item>
            <tr>
                <td class="right-align">
                    ${item.key.name}
                </td>
                <td class="right-align">
                    ${item.value}
                </td>
            </tr>
        </#list>

        </tbody>
    </table>

    <p>
        ИП Михаленя А.М.:
    </p>

    <br/>

    <table>
        <thead>
        <tr>
            <td>Филиал</td>
            <td>Общая сумма выставленных счетов</td>
        </tr>
        </thead>
        <tbody>

        <#list data.getMichaleniaTransactionsByBranchOffice() as item>
            <tr>
                <td class="right-align">
                    ${item.key.name}
                </td>
                <td class="right-align">
                    ${item.value}
                </td>
            </tr>
        </#list>

        </tbody>
    </table>


    <p>
        Список транзакций:
    </p>

    <br/>

    <table>
        <thead>
        <tr>
            <td>ФИО ребенка</td>
            <td>Сумма счета</td>
            <td>Количество выставленных занятий в счете</td>
            <td>Остаток занятий на момент выставления счета</td>
        </tr>
        </thead>
        <tbody>

        <#list data.getTransactions() as item>
            <tr>
                <td class="right-align">
                    ${item.child.getFullName()}
                </td>
                <td class="right-align">
                    ${item.invoiceAmount}
                </td>
                <td class="right-align">
                    ${item.numberOfLessons}
                </td>
                <td class="right-align">
                    ${item.child.tuitionBalance}
                </td>
            </tr>
        </#list>

        </tbody>
    </table>

</div>
</body>
</html>
