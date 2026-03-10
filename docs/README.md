# Echo

Минималистичный агрегатор для тех, кто ценит чистоту и объективность. 
Он группирует статьи из разных СМИ по одной теме в единый сюжет, позволяя 
увидеть разные точки зрения на одно событие без лишних повторов.

**Стек:** Натив с прямым использованием Android SDK.

## Сборка и установка

Запустите нужный вам эмулятор:

```txt
./emulator -list-avds
```

```txt
./emulator -avd <emulator_name>
```

Затем собирите и установите на него:

```txt
./gradlew installDevDebug
```

## Запуск

```txt
./adb shell monkey -p ru.tsu.echoSample.app.dev.debug -c android.intent.category.LAUNCHER 1
```