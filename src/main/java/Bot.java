import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    final private String botToken = "";
    final private String botName = "";

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                //��������� �� ������� ��������� ������������
                Message inMess = update.getMessage();
                //������� �� inMess id ���� ������������
                String chatId = inMess.getChatId().toString();
                //�������� ����� ��������� ������������, ���������� � ���������� ���� ����������
                String response = parseMessage(inMess.getText());
                //������� ������ ������ SendMessage - ��� ������� ����� ������������
                SendMessage outMess = new SendMessage();

                //��������� � ���� ��������� id ���� � ����� ��� �����
                outMess.setChatId(chatId);
                outMess.setText(response);

                //�������� � ���
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg) {
        String response = null;

        //���������� ����� ������������ � ������ ���������, �� ������ ����� ��������� �����
        if (textMsg.equals("/start"))
            response = "������\uD83D\uDD90\n" +
                    "\n" +
                    "\"�������\" \n" +
                    "\"��������\"\n" +
                    "\"���������\"\n" +
                    "\n" +
                    "���� ��� ���� ��� �� ������ ����� - Welcome and Follow me\uD83D\uDE09\n" +
                    "\n" +
                    "���� ����� ����� � ���� ��� ���������� ���� � ��������� KnubiSoft, � ������� � ������ Java\uD83D\uDC68\u200D\uD83D\uDCBB\n" +
                    "\n" +
                    "������ ������ �����\uD83D\uDC47:\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D";

        else if (textMsg.equals("/whoWeAre"))
            response = "Knubisoft - ��� IT �������� � ������� ������ � ������� ���������� ����������, ���������, ��������������� � ����������� ����, ������� ������������� ����������� ��������, � ����� ��������� ������� ��� ���� ��� �������� �� ����� ����.\n" +
                    "\n" +
                    "\uD83E\uDDD0 \uD83D\uDCB0 \uD83E\uDE7A \uD83D\uDCB6 \uD83D\uDD10 \uD83C\uDF0E\n" +
                    "\n" +
                    "Cool, right?) ��� ��������� �����\uD83D\uDC47:\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D";

        else if (textMsg.equals("/whereWeAre"))
            response = "� ������� Knubisoft ��� \"�������\" ������ ����� � ����� ������ ��������.\n" +
                    "����� �� �������� �������� �� ���� ������� � ������������ ���� ����� ����������� ����� �� ������ ������� � ����� ����.\n" +
                    "\n" +
                    "\uD83C\uDF3F \uD83C\uDFE3 \uD83E\uDDE1 \uD83C\uDF07 \uD83E\uDD1D \uD83D\uDC69\u200D\uD83C\uDF93 \uD83C\uDF0E\n" +
                    "\n" +
                    "�� �������) Click more\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0";

        else if (textMsg.equals("/howWeTeachAndLearn"))
            response = "�� ��������� ������� ������� ���������� ����������������������� ������������, ������� �������� �������� ����� \"Education Center\", � ������� ������� Knubisoft �������� ������� ������������ �������� ������ � ������ ������.\n" +
                    "\n" +
                    "\uD83D\uDC68\u200D\uD83C\uDFEB \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDE24 \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDE2B \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDC69\u200D\uD83C\uDF93 \uD83E\uDD1D \uD83C\uDFE3\n" +
                    "\n" +
                    "Not tired?) ����� ���������\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1";

        else if (textMsg.equals("/howWeHaveFun"))
            response = "�� ������������ �������� Knubisoft: \n" +
                    "\n" +
                    "\"������� ������� � ��������� � ����� ������� ������!)\"\n" +
                    "\n" +
                    "� ����� ������ �� �������������� ��������� �����������: ���������� ����, ������������ �����������, ������ �������� ������ � ������������� �����������.\n" +
                    "\n" +
                    "\uD83E\uDD73 \uD83E\uDD2A \uD83E\uDD1D \uD83D\uDC68\u200D\uD83D\uDCBB \uD83C\uDFE3 \uD83C\uDFB2 \uD83C\uDFAF \uD83C\uDFAE \uD83E\uDDE9\n" +
                    "\n" +
                    "�������� �������!) Click on\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93";

        else if (textMsg.equals("/howWeAreHelping"))
            response = "��� ������� �� ������� Knubisoft ����� ���� ����������.\n" +
                    "��������� ���, �� ��� ��������� ������� ���� ������������ ������ � ������ ���������� ���������� ����������� ������������ ��� ����� ������ �� ��������� ����� �������: �����, �����, �������� ��� ����������.\n" +
                    "\n" +
                    "Take care!\n" +
                    "Everything will be Ukraine)\n" +
                    "\n" +
                    "\uD83D\uDC68 \uD83E\uDDD1 \uD83C\uDD98 \uD83D\uDCB3 \uD83E\uDD1D \uD83D\uDE9A \uD83C\uDF71 \uD83D\uDE4C\n" +
                    "\n" +
                    "�� ������� ����������) More?\uD83D\uDC47:\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73";
        else {
            response = "Catch our links\uD83D\uDC47:\n" +
                    "\n" +
                    "\uD83C\uDF10 knubisoft.com/\n" +
                    "\n" +
                    "\uD83C\uDF10 instagram.com/knubisoft/\n" +
                    "\n" +
                    "\uD83C\uDF10 linkedin.com/company/knubisoft/mycompany/\n" +
                    "\n" +
                    "����� ���� ������ ���� �����\uD83E\uDD73";
        }
        return response;
    }
}
