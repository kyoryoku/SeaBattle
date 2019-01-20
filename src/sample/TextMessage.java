package sample;

public final class TextMessage {

    //массив надписей на кнопку СТРЕЛЯТЬ

    static String[] messageInButton =
            {
                    "АГООООНЬ!!1",
                    "Весь мир в труху...",
                    "Запустить торпеду!",
                    "Бахнуть ракетой!",
                    "Пошла! Пошла, родимая!",
                    "А что это за кнопка?",
                    "НЕ НАЖИМАТЬ!!!",
                    "пиу пиу пиу"
            };

    static int index = 0;

    static int getIndex(){
        if (index == messageInButton.length - 1) {
            index = 0;
        } else {
            index++;
        }
        return index;
    }
}
