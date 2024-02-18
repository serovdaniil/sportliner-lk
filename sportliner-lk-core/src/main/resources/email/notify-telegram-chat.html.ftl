<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="by.sportliner.lk.core.model.TelegramChat" -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sportliner LK. Новая заявки из телеграм</title>
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
        Из Telegram-бота поступила новая заявка:
    </p>

    <br/>

    <table>
        <thead>
        <tr>
            <td>Telegram username</td>
            <td>Контактный телефон</td>
            <td>Филиал</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="right-align">
                ${data.username}
            </td>
            <td class="right-align">
                ${data.phone}
            </td>
            <td class="right-align">
                ${data.branchOffice.name}
            </td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
