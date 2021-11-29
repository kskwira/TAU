from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import logging

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)


# Test 1
logger.info('Rozpoczynam test 1')
driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

logger.info('Przechodzę na stronę Zalando')
driver.get('https://www.zalando.pl/')
driver.maximize_window()
time.sleep(3)
logger.info('Przechodzę na stronę logowania')
temp = driver.find_element(By.CLASS_NAME, 'z-navicat-header_navToolItemLink')
temp.click()
time.sleep(3)
logger.info('Wpisuję login')
temp = driver.find_element(By.ID, 'login.email')
temp.click()
temp.send_keys("login")
time.sleep(3)
logger.info('Klikam zaloguj')
temp = driver.find_element(By.XPATH, '//button[@class="DJxzzA u9KIT8 uEg2FS U_OhzR ZkIJC- Vn-7c- '
                                     'FCIprz heWLCX JIgPn9 LyRfpJ pxpHHp Md_Vex NN8L-8 GTG2H9 MfX1a0 '
                                     'WCjo-q EKabf7 aX2-iv r9BRio mo6ZnF E6Km4r"]')
temp.click()
time.sleep(3)
temp = driver.find_element(By.XPATH, '//div[@role="alert"]/span[1]')
alert = temp.text
if alert == 'Podaj pełny adres e-mail (np. jan.kowalski@domena.pl).':
    logger.info('Test 1 wykonany poprawnie')
else:
    logger.error('Niepoprawny alert')

driver.close()


# Test 2
logger.info('Rozpoczynam test 2')
driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

logger.info('Przechodzę na stronę Zalando')
driver.get('https://www.zalando.pl/')
driver.maximize_window()
time.sleep(3)
try:
    logger.info('Zamykam banner z preferencjami cookies')
    temp = driver.find_element(By.XPATH, '//*[@id="uc-btn-accept-banner"]')
    temp.click()
    time.sleep(3)
except:
    logger.warning('Brak bannera')

logger.info('Przechodzę na link "pomoc i kontakt"')
temp = driver.find_element(By.CLASS_NAME, 'z-navigation-footer_sectionContentLink')
temp.click()
time.sleep(3)
logger.info('Przechodzę na link "śledzenie przesyłki"')
temp = driver.find_element(By.LINK_TEXT, 'Śledzenie przesyłki')
temp.click()
time.sleep(3)
logger.info('Przechodzę na link DPD')
temp = driver.find_element(By.XPATH, '//div[@class="article__body"]/div/ul[3]/li/span/a')
temp.click()
time.sleep(3)
url = driver.current_url
if url == 'https://mojapaczka.dpd.com.pl/login':
    logger.info('Test 2 wykonany poprawnie')
else:
    logger.error('Niepoprawny URL')

driver.close()


# Test 3
logger.info('Rozpoczynam test 3')
driver = webdriver.Firefox(executable_path='C:\geckodriver.exe')

logger.info('Przechodzę na stronę Google')
driver.get('https://www.google.pl/')
driver.maximize_window()
time.sleep(3)
try:
    logger.info('Zamykam banner z preferencjami cookies')
    temp = driver.find_element(By.XPATH, '/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div')
    temp.click()
    time.sleep(3)
except:
    logger.warning('Brak bannera')

logger.info('Wpisuję wikipedia')
temp = driver.find_element(By.NAME, 'q')
temp.click()
temp.send_keys('wikipedia')
time.sleep(3)
temp.submit()
time.sleep(3)
logger.info('Przechodzę na pierwszy znaleziony link')
temp = driver.find_element(By.XPATH, '//div[@id="search"]/div/div/div[1]/div/div/div/div/div/div[1]/a')
temp.click()
time.sleep(3)
temp = driver.find_element(By.ID, 'main-page-welcome')
text = temp.text
if text == 'Witaj w Wikipedii,':
    logger.info('Test 3 wykonany poprawnie')
else:
    logger.error('Niepoprawna wiadomość powitalna')

driver.close()


# Test 4
logger.info('Rozpoczynam test 4')
driver = webdriver.Firefox(executable_path='C:\geckodriver.exe')

logger.info('Przechodzę na stronę Wikipedia')
driver.get('https://pl.wikipedia.org')
driver.maximize_window()
time.sleep(3)
logger.info('Przechodzę na język angielski')
temp = driver.find_element(By.XPATH, '//li[@class="interlanguage-link interwiki-en mw-list-item"]/a')
temp.click()
time.sleep(3)
logger.info('Sprawdzam wiadomość powitalną [ang]')
temp = driver.find_element(By.ID, 'mp-welcome')
text = temp.text
if text == 'Welcome to Wikipedia,':
    logger.info('Test 4[ang] wykonany poprawnie')
else:
    logger.error('Niepoprawna wiadomość powitalna [ang]')

logger.info('Przechodzę na język japoński')
temp = driver.find_element(By.XPATH, '//li[@class="interlanguage-link interwiki-ja mw-list-item"]/a')
temp.click()
time.sleep(3)
logger.info('Sprawdzam wiadomość powitalną [jp]')
temp = driver.find_element(By.ID, 'welcome')
text = temp.text
if text == 'ウィキペディアへようこそ':
    logger.info('Test 4[jp] wykonany poprawnie')
else:
    logger.error('Niepoprawna wiadomość powitalna [jp]')

driver.close()
