#* @author Jacob Igel
#* Introduction to R


# pacman ------------------------------------------------------------------


pacman::p_load(tidyverse,
               rvest, # for web scraping in R
               lubridate, # fix date column
               magrittr, # has some pope and extract functions that we may use
               tidycensus, # for getting the census data
               jsonlite, httr, # pkgs that we might use for API
               janitor,
               skimr,
               DataExplorer,
               hms, # for date and times respectively
               pointblank,
               deducorrect,
               editrules,
               VIM
)
# 01/26/22 ----------------------------------------------------------------
## ^^ ctrl + shift + r --> insert section

## Declaring a variable
x1 = 3

## Using logical operators will return T/F in the console
x1 > 5
x1 < 5

## Sublist names
lst <- list( # list constructor/creator
    sub1 = 1:3, # atomic double/numeric vector  of length = 3
    sub2 = "a", # atomic character vector of length = 1 (aka scalar)
    sub3 = c(TRUE, FALSE, TRUE), # atomic logical vector of length = 3
    sub4 = c(2.3, 5.9) # atomic double/numeric vector of length =3
)
lst # printing the list

str(
    list(first_el = lst, second_el = iris)
)

mean(lst$sub1, trim = 0.5)

temp_high_forecast = 1:10
mean(x = temp_high_forecast, trim = 0, na.rm = TRUE) # This will work
mean(x = temp_high_forecast,TRUE, 0) 


# 01/31/22 ----------------------------------------------------------------

## Preface
x_vec = rnorm(10)
x_vec[10]
x_vec[-c(1,9)]


# Reading CSV Data --------------------------------------------------------

# installing the pacman package if required 
if(require(pacman)== FALSE) install.packages("pacman")

pacman::p_load(tidyverse)

## Alternatively
if(require(tidyverse)== FALSE) install.packages("tidyverse")
library(tidyverse)


qb1 = read_csv("burrow_stats_2021_season_prior_to_chiefs_game.csv")
glimpse(qb1) # this is similar to the str() -> prints more nicely in console

# Dimension related things
ncol(qb1) # number of columns
nrow(qb1) # number of rows
dim(qb1) # number of rows and columns (the dimension)

qb1

# FRED Data
unrate = read_csv("https://fred.stlouisfed.org/graph/fredgraph.csv?bgcolor=%23e1e9f0&chart_type=line&drp=0&fo=open%20sans&graph_bgcolor=%23ffffff&height=450&mode=fred&recession_bars=on&txtcolor=%23444444&ts=12&tts=12&width=748&nt=0&thu=0&trc=0&show_legend=yes&show_axis_titles=yes&show_tooltip=yes&id=UNRATE&scale=left&cosd=1948-01-01&coed=2021-12-01&line_color=%234572a7&link_values=false&line_style=solid&mark_type=none&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Monthly&fam=avg&fgst=lin&fgsnd=2020-02-01&line_index=1&transformation=lin&vintage_date=2022-01-31&revision_date=2022-01-31&nd=1948-01-01")
glimpse(unrate)
# why some people prefer readr functions compared to "base r"

unrate2 = read.csv("https://fred.stlouisfed.org/graph/fredgraph.csv?bgcolor=%23e1e9f0&chart_type=line&drp=0&fo=open%20sans&graph_bgcolor=%23ffffff&height=450&mode=fred&recession_bars=on&txtcolor=%23444444&ts=12&tts=12&width=748&nt=0&thu=0&trc=0&show_legend=yes&show_axis_titles=yes&show_tooltip=yes&id=UNRATE&scale=left&cosd=1948-01-01&coed=2021-12-01&line_color=%234572a7&link_values=false&line_style=solid&mark_type=none&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Monthly&fam=avg&fgst=lin&fgsnd=2020-02-01&line_index=1&transformation=lin&vintage_date=2022-01-31&revision_date=2022-01-31&nd=1948-01-01")
glimpse(unrate2)
# this shows the dates as characters while read_csv shows them as actual dates


# approach 3 for the FRED Data
download.file(url ="https://fred.stlouisfed.org/graph/fredgraph.csv?bgcolor=%23e1e9f0&chart_type=line&drp=0&fo=open%20sans&graph_bgcolor=%23ffffff&height=450&mode=fred&recession_bars=on&txtcolor=%23444444&ts=12&tts=12&width=748&nt=0&thu=0&trc=0&show_legend=yes&show_axis_titles=yes&show_tooltip=yes&id=UNRATE&scale=left&cosd=1948-01-01&coed=2021-12-01&line_color=%234572a7&link_values=false&line_style=solid&mark_type=none&mw=3&lw=2&ost=-99999&oet=99999&mma=0&fml=a&fq=Monthly&fam=avg&fgst=lin&fgsnd=2020-02-01&line_index=1&transformation=lin&vintage_date=2022-01-31&revision_date=2022-01-31&nd=1948-01-01",
              destfile = "unrate.csv")

unrate3 = read_csv("unrate.csv")


# NYT Data 

## Go to the link
### Clicked on view raw data
### https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-states.csv

pacman::p_load(vroom, readxl, jsonlite)

who = read_xlsx("IndicatorData-20220131174902998.xlsx")


# JSON Data ---------------------------------------------------------------

nobel = fromJSON("http://api.nobelprize.org/v1/laureate.json")

# would overwrite the nobel list
# extract the first sublist based on our glimpse(nobel)
# save the extracted sublist into a tibble format instead of a data frame

nobel = nobel[[1]] %>% as_tibble()
nobel

write_csv(nobel, file = "nobel_winners.csv")


# Scraping the ISA Website ------------------------------------------------

pacman::p_load(tidyverse,
               rvest, # for web scraping in R
               lubridate, # fix date column
               magrittr) # has some pope and extract functions that we may use





# * Approach 1 (Saving all intermediate steps) ----------------------------

step0 = "https://bulletin.miamioh.edu/courses-instruction/isa/"

# use R to get the entire page source into your PC

step1 = read_html(x = step0) # x gets assigned to the link
step1 # see object of type list

# specify which parts of the page that I am interested in
## for starters: we will scrape all course titles
step2_course_titles = html_elements(x = step1,
                                    css = "p.courseblocktitle > strong"
                                    )
step2_course_titles

# make the obtained text easier to read and understand by an actual person
step3_course_titles = html_text2(x = step2_course_titles)
step3_course_titles


# *  Approach 2 (Using the pipe) ------------------------------------------
### Use a different HTML/CSS selector to show you that the solution is not
### unique

# renaming step1 to something meaningful
# you only need to read a given page once
isa_course_page = step1

isa_course_page %>%
    # select relevant elements (for the titles)
    html_elements(css ="div.courseblock > p.courseblocktitle > strong") %>%
    html_text2() ->
    isa_titles

# showing you here that there are no differences between the object from
# approach 1 and approach 2
setdiff(isa_titles, step3_course_titles)



# * Getting the course description ----------------------------------------
isa_course_page %>%
    # select the relevant html elements based on inspecting the doc on Edge
    html_elements(css = "p.courseblockdesc") %>%
    # converting it to readable text
    html_text2() ->
    isa_course_descriptions


# * Not a unique selector (but reasonable results) ------------------------
isa_course_page %>%
    # select the relevant html elements based on inspecting the doc on Edge
    html_elements(css = "p") %>%
    # converting it to readable text
    html_text2() ->
    isa_all

head(isa_all, 10)

isa_course_descriptions_2 = isa_all[seq(from = 2, to = 110, by = 2)]
isa_course_titles_2 = isa_all[seq(from = 1, to = 110, by = 2)]

# Cleaning the "\n" from the course descriptions
isa_course_descriptions_cleaned = str_replace_all(
    string = isa_course_descriptions_2,
    pattern = "\n", # used an extra "\" as escape sequence so
    # I am telling R that I am intentionally looking for "\n"
    replacement = " ")

# Solely dependent on having both vectors to be of the same size
# if not you will get an error
isa_courses = tibble(course_title = isa_course_titles_2,
                     course_descriptions = isa_course_descriptions_2)

# Exporting the results 
write_csv(x = isa_courses,
          file = "ISA_courses.csv")

# Plane Crash Data --------------------------------------------------------
read_html("http://www.planecrashinfo.com/2021/2021.htm") %>%
    # select html elements of interest (the only table)
    html_elements("table") %>%
    # we clean tables via html_table and not html_text2
    html_table -> crashes2021

# given that the output is a list of 1, we will extract that out 
# the result should be a tibble of 10 obs and 4 var
# based on inspecting global environment

crashes2021 = crashes2021[[1]]
crashes2021

# * Fixing the column names issue -----------------------------------------
# Approach 1 
## Rename the column names to row 1, and then
## delete the first row

crashes2021[1, 1:4]
crashes2021[1, ] # all columns, same as above
colnames(crashes2021) = crashes2021[1, ] # the first row
crashes2021[-1, ] # or crashes[2:10, ]
crashes2021 = crashes2021[-1, ]

# optional - implemented based on a comment in class
# we will do this in the future as well
crashes2021$Date = dmy(crashes2021$Date)
glimpse(crashes2021)


# Approach 2
read_html("http://www.planecrashinfo.com/2021/2021.htm") %>%
    # select html elements of interest (the only table)
    html_elements("table") %>%
    # we clean tables via html_table and not html_text2
    html_table(header = 1) %>% # header = 1 (use first row as header)
    # extract2 from magrittr is equivalent of [[1]]
    # extract the first sublist
    extract2(1) -> 
    crashes2021b


# * For Loops! ------------------------------------------------------------

# very basic description of what a for loop does
# repeat the operation below 10 times while incrementing elem by 1

for (elem in 1:10) {
    print("----")
    print(elem)
    print("----")
    
}


# * For Scraping ----------------------------------------------------------

base_url = "http://www.planecrashinfo.com/"

years = 2017:2022 # 5 years (as an example)

# initializing the results object
crashes_5yrs = tibble()

for (i in 1:5) {
    url_interest = paste0(base_url,
                          years[i],
                          "/",
                          years[i],
                          ".htm")
    
    read_html(url_interest) %>%
        # select html elements of interest (the only table)
        html_elements("table") %>%
        # we clean tables via html_table and not html_text2
        html_table(header = 1) %>% # header = 1 (use first row as header)
        # extract2 from magrittr is equivalent of [[1]]
        # extract the first sublist
        extract2(1) -> 
        temp_tbl
    
    # I will overwrite temp_tbl as I increment in the loop
    # so I will need to save the results somehow
    crashes_5yrs = rbind(crashes_5yrs, temp_tbl)
    
}


# Approach 2 - write your own function
## follows the good practice of do not copy your code more than once

scrape_crash_site = function(x) {
    read_html(url_interest) %>%
        # select html elements of interest (the only table)
        html_elements("table") %>%
        # we clean tables via html_table and not html_text2
        html_table(header = 1) %>% # header = 1 (use first row as header)
        # extract2 from magrittr is equivalent of [[1]]
        # extract the first sublist
        extract2(1) -> 
        results
    
        return (results)
}

# we checked that the function is working here 
scrape_crash_site(x = "http://www.planecrashinfo.com/2021/2021.htm")

# vector_of_urls = c("http://www.planecrashinfo.com/2021/2020.htm",
#                     "http://www.planecrashinfo.com/2021/2021.htm")

# With a bit of luck, I was able to create the vector of webages (url)
vector_of_urls2 = paste0(base_url, 
                         2017:2021,
                         "/",
                         2017:2021,
                         ".htm")

# we will be applying the function repeatably with the data above
# we went to return a data frame object 
# we will use a function called map_df from purrr (loaded with tidyverse)

crashes_5yrsb = map_df(.x = vector_of_urls,
                       .f = scrape_crash_site)


# * Scraping Class PDFs ---------------------------------------------------

"https://github.com/fmegahed/isa401/tree/main/PDFs" %>%
    # reading the html as always
    read_html() %>%
    # specifying the css selector
    html_elements("div.flex-auto.min-width-0.col-md-2.mr-3 > span > a") %>%
    # extracting the hyperlinks
    html_attr('href') %>%
    # making it a full link
    url_absolute(base = 'https://github.com/') ->
    pdf_links

str_replace(string = pdf_links,
            pattern = "blob",
            replacement = "raw")

pdf_links[1]

pdf_links
download.file(url = "https://github.com/fmegahed/isa401/raw/main/PDFs/05_lab_scraping_and_markdown.pdf" ,
              destfile = '05.pdf',
              mode = "wb")


number_do_pdf_vec = paste0("0", 1:5, ".pdf")

map2(.x = pdf_links[1:5],
     .y = number_do_pdf_vec,
     .f = download.file,
     mode = "wb")
# 
#  for (i in 1:5) {
#      download.file(url = pdf_links[i],
#                    destfile = number_do_pdf_vec[i],
#                    mode = 'wb')
#      
#  }

download.file(url = pdf_links[1:5],
              destfile = number_do_pdf_vec,
              mode = "wb")


# Census Data -------------------------------------------------------------

pacman::p_load(tidyverse,
               rvest, # for web scraping in R
               lubridate, # fix date column
               magrittr, # has some pope and extract functions that we may use
               tidycensus, # for getting the census data
               jsonlite, httr, # pkgs that we might use for API
               janitor
) 

# * tidycensus ------------------------------------------------------------
census_key = 'f5748873b861c5241b7c893abc28891a81a0f1f5'

census_api_key(key = census_key)

butler_warren = get_decennial(geography = 'county',
                              variables = 'P1_001N',
                              year = 2020,
                              county = c('Butler County', 'Warren County'),
                              state = 'OH')
butler_warren



# * * From the Census API -------------------------------------------------

# ref: https://api.census.gov/data/2020/dec/pl/examples.html

search_url = paste0('https://api.census.gov/data/2020/dec/pl?get=NAME&for=county:017,165&in=state:39&key=',
                    census_key)

search_url

# After copying the URL into my browser, we suspected that this is a nested data
# so it's likely that it's a JSON dataset

butler_warren_from_api = fromJSON(txt = search_url)

#explanation of the two-way pipe (%<>%) (run ONLY one of the three lines of code below)

#1
butler_warren_from_api %<>% janitor:: row_to_names(row_number = 1) %>% as_tibble()

#2
# butler_warren_from_api %<>% janitor:: row_to_names(row_number = 1) -> butler_warren_from_api

#3
# butler_warren_from_api = as_tibble(row_to_names(dat = butler_warren_from_api, row_number = 1))


# * Accuweather -----------------------------------------------------------

# location: 340019
accu_key = 'EoqCTpBVxzzSWTwiRAtV6f1AycwVacuI'

accu_weather = fromJSON(txt ='http://dataservice.accuweather.com/forecasts/v1/daily/5day/340019?apikey=EoqCTpBVxzzSWTwiRAtV6f1AycwVacuI')

accu_weather$DailyForecasts

weather_forcast = accu_weather$DailyForecasts


# CryptoCompare -----------------------------------------------------------

cc_key = '6789ec76ff6877cba6ef8e5be199824d37320123e4bbedfcf7ea3ac02025540d'

# my request URL from the documentation, with my cc_key appended
request_url = paste0('https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR&api_key=',
                cc_key)

# used my observation that the API is returning a JSON object 
# so I am reading the HSON from the web based on the fromJSON()
btc_converstions = fromJSON(txt = request_url)

# Optional if you want to clean this
btc_converstions = unlist(btc_converstions,
                          recursive = FALSE) # set to false as I wanted to keep the names

# From the named vector, I pull the names using the base R names()
# values are just the values in the newly created numeric vector
btc_single_tibble = tibble(name = names(btc_converstions),
                           price = btc_converstions)

request_url2 = paste0('https://min-api.cryptocompare.com/data/v2/histoday?fsym=SHIB&tsym=USD&limit=100&api_key=',
                     cc_key)

shib_list = fromJSON(txt = request_url2)
shib_list %>% glimpse() # showing the str of the list

shib_tibble = shib_list$Data$Data # based on the fact that we have a data df under the data sublist
shib_tibble2 = shib_list[['Data']][['Data']] # an alternative approach to the line above
str(shib_tibble)

# Not piping per the request of class
shib_tibble$time = as_datetime(shib_tibble$time)
class(shib_tibble$time) #technically a date time object
shib_tibble$time = as_date(shib_tibble$time)
shib_tibble$time #printing this (no UTC in the output)



# Tidy Data ---------------------------------------------------------------

df = table1 %>%
    mutate(cases_per_10000_ppl = 10000*cases/population)

# How you would visualize this data in R
# we will not focus on the logic today (but the fact that you can do it
# easily with this format)
df

df %>%
    #comes from the ggplot2 pkg (creates a canvas)
    ggplot(aes(x = year, y = cases_per_10000_ppl, color = country)) + 
    geom_point(size = 2) + # creating a point for each observation, colored by count
    geom_line()



# * pivot_longer() for table4a --------------------------------------------
table4a
table4a_tidy = table4a %>%
    pivot_longer(cols = c(2,3),
                 # name of the column that will combine the colnames for cols 2 and 3
                 names_to = 'year', 
                 # the name of the column that will contain their associated values
                 values_to = 'cases')


# Optional -- what you did a lot in ISA 245
table4b
table4b_tidy = table4b %>%
    pivot_longer(cols = c(2,3), # offending the columns
                 # name of the column that will combine the colnames for cols 2 and 3
                 names_to = 'year', 
                 # the name of the column that will contain their associated values
                 values_to = 'population')

table_complete_tidy = left_join(x = table4a_tidy, y = table4b_tidy,
                                by = c('country' = 'country', 'year' = 'year'))

table_complete_tidy


# * pivot_wider() for table2 ----------------------------------------------
table2
table2_tidy = table2 %>%
    # by looking at where the 2 variables are stored when printing table2
    pivot_wider(names_from = 'type',
                values_from = 'count')
table2_tidy


deaths = read.csv('covid_deaths_usafacts.csv', stringsAsFactors = F)
deaths



deaths_tidy = deaths %>%
    pivot_longer(cols = 5:762, # or col = starts_with('X')
                 # name of the column that will combine the colnames for 5 on
                 names_to = 'date', 
                 # the name of the column that will contain their associated values
                 values_to = 'counts')
deaths_tidy

# conversion of the character date column does not effect our definition of "tidy
# however, it does make the data "cleaner", i.e., more ready for analysis

# converting the chr date to a real date in R
deaths_tidy$date = ymd(deaths_tidy$date)


# * Checking Column Types -------------------------------------------------


iris_tbl = tibble(iris) %>% clean_names()

class(iris_tbl$sepal_length)
sapply(iris_tbl,class)
str(iris_tbl)
map_chr(iris_tbl,class)
glimpse(iris_tbl)
skim(iris_tbl) # this one is really nice
plot_str(iris_tbl)


# The Bike Sharing Dataset ------------------------------------------------

#read_csv
bike_tbl = read_csv('https://raw.githubusercontent.com/fmegahed/isa401/main/Data/bike_sharing_data.csv')
glimpse(bike_tbl) #from dplyr package (same as str but prints better)
problems() #investigating the problems based on the warning message-

bike_tbl[14177:14179, 8] #investigating how the read_csv fixed this issue 

#read.csv
bike_base = read.csv('https://raw.githubusercontent.com/fmegahed/isa401/main/Data/bike_sharing_data.csv')
glimpse(bike_base) # makes all of the humidity variables characters instead of double

# From now on, we will work with the bike_tbl (for the sake of having a unified
# example in class)

# * Make Data Tidy --------------------------------------------------------

bike_tbl %<>% mutate(datetime = mdy_hm(datetime),
                     date = as_date(datetime),
                     hours = hour(datetime))
# making the data tidy by removing the datetime column which had two variables

bike_tbl %<>% select(-datetime) %>%
    relocate(date, hours) # this will move the date and hour to be your first two cols
bike_tbl
glimpse(bike_tbl)

# * Make The Data Technically Correct  ------------------------------------
## Change multiple columns in a single step (mutate_at()) from dplyr

bike_tbl %>% mutate_at(.vars = vars(hours, season, holiday, workingday, weather),
                       .funs = as.factor) %>%
    # converts from char to factor
    mutate_at(.vars = vars(hours, season, holiday, workingday, weather),
              .funs = as.factor) -> bike_tbl

glimpse(bike_tbl) # from this output I can now say that we have technically correct data

bike_tbl %<>% mutate(holiday = recode(holiday, '0' = 'Yes', '1' = 'No'),
                    workingday = recode(workingday, '0' = 'No', '1' = 'Yes'))

# * Make the data consistent ----------------------------------------------


# A Step - figure out which cells have some issues (we will capitalize on pointblank package here)
act = action_levels(warn_at = 0.01, notify_at = 0.01)

agent = create_agent(tbl = bike_tbl, actions = act) %>% 
    col_vals_between(columns = vars(temp, atemp), left = -20, right = 45) %>%
    col_vals_gte(columns = vars(humidity), value = 0) %>%
    col_vals_expr(expr = expr(count == registered + casual)) %>%
    # previous check that all sources should have contained google
    col_vals_expr(expr = ~ str_detect(sources, pattern = 'google'),
                  label = 'non_google_sources')

interrogate(agent, sample_limit = nrow(bike_tbl))




# Data Correction and Imputation ------------------------------------------


# * Examining the Correct Rounding Package --------------------------------

E = editset("x + y == z")
df = data.frame(x = 101, y = 100, z = 200)

corrected_data = correctRounding(E, dat = df)

# Answer will be correct but potentially different than the slides
corrected_data$corrected

cdf <- data.frame(x = 100, y = 100, z = 200)
corrected_data2 = correctRounding(E, dat = cdf)
corrected_data2$corrected


# Correct with Rules (Trying to make it work) -----------------------------

d <- data.frame(x = 173, y = 200, z = 379)
correctWithRules(rules = E, d) # no changes based on the output
u = correctWithRules(x = expression(
    if(x + y != z) z = x + y
))
correctWithRules(rules = u, d)


# * Demo ------------------------------------------------------------------


df = iris %>% tibble()
df

# how many missing values do we have in the entire data
total_missing = is.na(df) %>% sum()

df[1:5, 1:2] = NA # making some fake missing data

sl_mean = mean(df$Sepal.Length, na.rm = T)
sw_median = median(df$Sepal.Width, na.rm = T)

df_completed1 = df %>%
    replace_na(
        # replacing the NAs in COl 1 with their mean
        list(Sepal.Length = sl_mean,
             #replacing the NAs in col 2 with their median
                    Sepal.Width = sw_median))
df_completed1

# * Suggestion (If you should impute, use a method that capitalize --------

# if your dataset is very large, kNN is extremely inefficient
# for every observation containing missing data, it will compute a dist
# to all the remaining observations in your data
# rank the observations
# it will use the top 5 observations (ones with the least dist)
# for numeric data it defaults to using the median of the 5 obs
# for imputing it
# for categorical, it will use the mode(most frequent value)
df_completed2 = VIM::kNN(data = df, k = 5)
