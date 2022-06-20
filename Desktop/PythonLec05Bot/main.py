from telegram import Update
from telegram.ext import Updater, CommandHandler, CallbackContext
from bot_commands import*


def hello(update: Update, context: CallbackContext) -> None:
    update.message.reply_text(f'Hello {update.effective_user.first_name}')


updater = Updater('5279205415:AAGyhyGdD7QkmR3ykZvzbHSO896AhaBGnKw')

updater.dispatcher.add_handler(CommandHandler('hello', hello))
print('server start')
updater.start_polling()
updater.idle()








# import matplotlib.pyplot as plt
# import numpy as np

# list = [0,1,5,6,7,8,3,10]
# plt.plot(list)

# plt.show()







# import emoji
# print(emoji.emojize('Python is :thumbs_up:'))





# from progress.bar import Bar
# import time

# bar = Bar('Processing', max=20)
# for i in range(20):
#     # Do some work
#     time.sleep(0.5)
#     bar.next()
# bar.finish()






# from isOdd import isOdd


# print(isOdd(1)) 
# print(isOdd(4)) 