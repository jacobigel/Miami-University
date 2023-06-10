import PySimpleGUI as sg      

#sg.theme('DarkAmber')    # Keep things interesting for your users

layout = [[sg.Text('Persistent window')],      
          [sg.Input(key='-IN-')],      
          [sg.Button('Read'), sg.Exit()]]      

window = sg.Window('Window that stays open', layout)      

while True:                             # The Event Loop
    event, values = window.read() 
    print(event, values)
    
    if event == sg.WIN_CLOSED or event == 'Exit':
        break      


window.close()
