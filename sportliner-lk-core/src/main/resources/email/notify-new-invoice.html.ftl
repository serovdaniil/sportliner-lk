<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="by.sportliner.lk.core.model.Child" -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sportliner LK. Создан новый счет для ребенка</title>
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
        Данные ребенка:
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
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="right-align">
                ${data.parent.fullName}
            </td>
            <td class="right-align">
                ${data.parent.phone}
            </td>
            <td class="right-align">
                ${data.branchOffice.name}
            </td>
            <td class="right-align">
                ${data.fullName}
            </td>
            <td class="right-align">
                ${data.fullInvoiceNumber}
            </td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
