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
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();
                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = parseMessage(inMess.getText());
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //Отправка в чат
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg) {
        String response = null;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (textMsg.equals("/start"))
            response = "Привет\uD83D\uDD90\n" +
                    "\n" +
                    "\"КОМАНДА\" \n" +
                    "\"РАЗВИТИЕ\"\n" +
                    "\"ПОДДЕРЖКА\"\n" +
                    "\n" +
                    "Если для тебя это не пустые слова - Welcome and Follow me\uD83D\uDE09\n" +
                    "\n" +
                    "Меня зовут Артем и этот бот познакомит тебя с компанией KnubiSoft, в которой я изучаю Java\uD83D\uDC68\u200D\uD83D\uDCBB\n" +
                    "\n" +
                    "Просто сделай выбор\uD83D\uDC47:\n" +
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
            response = "Knubisoft - это IT компания с большим опытом в области финансовых технологий, логистики, здравоохранения и банковского дела, которая разрабатывает собственные продукты, а также реализует проекты под ключ для клиентов по всему миру.\n" +
                    "\n" +
                    "\uD83E\uDDD0 \uD83D\uDCB0 \uD83E\uDE7A \uD83D\uDCB6 \uD83D\uDD10 \uD83C\uDF0E\n" +
                    "\n" +
                    "Cool, right?) Вот следующий пункт\uD83D\uDC47:\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D";

        else if (textMsg.equals("/whereWeAre"))
            response = "У команды Knubisoft два \"зеленых\" уютных офиса в самом сердце Харькова.\n" +
                    "Также мы работаем удаленно по всей Украине и поддерживаем идею найма талантливых людей из разных городов и стран мира.\n" +
                    "\n" +
                    "\uD83C\uDF3F \uD83C\uDFE3 \uD83E\uDDE1 \uD83C\uDF07 \uD83E\uDD1D \uD83D\uDC69\u200D\uD83C\uDF93 \uD83C\uDF0E\n" +
                    "\n" +
                    "Ты молодец) Click more\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0";

        else if (textMsg.equals("/howWeTeachAndLearn"))
            response = "Мы стремимся создать сильное сообщество высококвалифицированных специалистов, поэтому особенно гордимся нашим \"Education Center\", в котором команда Knubisoft помогает молодым специалистам получить знания и первую работу.\n" +
                    "\n" +
                    "\uD83D\uDC68\u200D\uD83C\uDFEB \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDE24 \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDE2B \uD83D\uDC68\u200D\uD83D\uDCBB \uD83D\uDC69\u200D\uD83C\uDF93 \uD83E\uDD1D \uD83C\uDFE3\n" +
                    "\n" +
                    "Not tired?) Тогда продолжим\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeHaveFun? \uD83E\uDD73\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1";

        else if (textMsg.equals("/howWeHaveFun"))
            response = "Мы поддерживаем традицию Knubisoft: \n" +
                    "\n" +
                    "\"Раздели веселье с коллегами в конце рабочей недели!)\"\n" +
                    "\n" +
                    "В наших офисах мы организовываем множество активностей: настольные игры, тематические корпоративы, уютные вечерние беседы и увлекательные путешествия.\n" +
                    "\n" +
                    "\uD83E\uDD73 \uD83E\uDD2A \uD83E\uDD1D \uD83D\uDC68\u200D\uD83D\uDCBB \uD83C\uDFE3 \uD83C\uDFB2 \uD83C\uDFAF \uD83C\uDFAE \uD83E\uDDE9\n" +
                    "\n" +
                    "Осталось немного!) Click on\uD83D\uDC47:\n" +
                    "\n" +
                    "/howWeAreHelping? \uD83E\uDD1D\n" +
                    "\n" +
                    "/whoWeAre? \uD83E\uDDD0\n" +
                    "\n" +
                    "/whereWeAre? \uD83D\uDCE1\n" +
                    "\n" +
                    "/howWeTeachAndLearn? \uD83D\uDC68\u200D\uD83C\uDF93";

        else if (textMsg.equals("/howWeAreHelping"))
            response = "Для каждого из команды Knubisoft важно быть волонтером.\n" +
                    "Благодаря Вам, мы уже отправили десятки тонн гуманитарной помощи и сейчас продолжаем поставлять необходимое оборудование для наших парней на передовую линию обороны: рации, дроны, наушники для артиллерии.\n" +
                    "\n" +
                    "Take care!\n" +
                    "Everything will be Ukraine)\n" +
                    "\n" +
                    "\uD83D\uDC68 \uD83E\uDDD1 \uD83C\uDD98 \uD83D\uDCB3 \uD83E\uDD1D \uD83D\uDE9A \uD83C\uDF71 \uD83D\uDE4C\n" +
                    "\n" +
                    "Мы отлично поработали) More?\uD83D\uDC47:\n" +
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
                    "Будем рады видеть тебя снова\uD83E\uDD73";
        }
        return response;
    }
}
