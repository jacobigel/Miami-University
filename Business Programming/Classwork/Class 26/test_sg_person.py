import PySimpleGUI as sg
import class24_2
#sg.theme('BluePurple')


## The keys are dictionary elements
# the results are in values[key]
# 
layout = [[sg.Text('Name'), sg.Input(key='-name-')],
          [sg.Text('Age'), sg.Text(size=(15,1),key='-age-')],
          [sg.Button('getPerson'), sg.Button('Exit')]]

window = sg.Window('Person', layout)

while True:  # Event Loop
    event, values = window.read()
    print(event, values)
    if event == sg.WIN_CLOSED or event == 'Exit':
        break
    if event == 'getPerson':
        name,age = class24_2.get_person(values['-name-'])
        # Update the "output" text element to be the value of "input" element
        window['-age-'].update(age)

window.close()
