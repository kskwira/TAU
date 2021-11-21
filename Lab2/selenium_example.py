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

driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

logger.info('Przechodzę na stronę Zalando')
driver.get('https://www.zalando.pl/')
driver.maximize_window()
time.sleep(1)
temp = driver.find_element(By.CLASS_NAME, 'z-navicat-header_navToolItemLink')
temp.click()
logger.warning('Jakieś ostrzeżenie')
time.sleep(1)
temp = driver.find_element(By.ID, 'login.email')
temp.click()
temp.send_keys("login")
time.sleep(1)
temp = driver.find_element(By.XPATH, '//button[@class="DJxzzA u9KIT8 uEg2FS U_OhzR ZkIJC- Vn-7c- '
                                     'FCIprz heWLCX JIgPn9 LyRfpJ pxpHHp Md_Vex NN8L-8 GTG2H9 MfX1a0 '
                                     'WCjo-q EKabf7 aX2-iv r9BRio mo6ZnF E6Km4r"]')
temp.click()
time.sleep(2)

logger.error('Jakiś Error')

driver.close()
