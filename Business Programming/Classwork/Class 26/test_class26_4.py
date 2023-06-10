import PySimpleGUI as sg

#sg.theme('BluePurple')

def convert_km(m):
    miles = float(m)
    ratio = 1.609344
    return round(miles*ratio,2)

## The keys are dictionary elements
# the results are in values[key]
# 
layout = [[sg.Text('Kilometers:'), sg.Text(size=(15,1), key='-km-')],
          [sg.Text('Miles'), sg.Input(key='-m-')],
          [sg.Button('Calculate KM'), sg.Button('Exit')]]

window = sg.Window('Miles-KM', layout)

while True:  # Event Loop
    event, values = window.read()
    print(event, values)
    if event == sg.WIN_CLOSED or event == 'Exit':
        break
    if event == 'Calculate KM':
        km = convert_km(values['-m-'])
        # Update the "output" text element to be the value of "input" element
        window['-km-'].update(km)

window.close()
