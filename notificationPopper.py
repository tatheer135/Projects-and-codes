from plyer import notification
import requests

def notifyMe(title, message):
    notification.notify(
        title = title,
        message = message,
        app_icon = r"C:\Users\HP\Downloads\hack.ico",
        timeout = 15

    )

def getData(url):
    r = requests.get(url)
    return r.text

if __name__ == "__main__":
    notifyMe("Dear User","You have been attacked!")
