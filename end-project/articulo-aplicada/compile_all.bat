@echo off
setlocal enabledelayedexpansion

rem ==== RUTAS / BINARIOS ====
set "MIKTEXBIN=%LOCALAPPDATA%\Programs\MiKTeX\miktex\bin\x64"
rem Usa las rutas completas si existen; si no, usa los comandos del PATH
if exist "%MIKTEXBIN%\xelatex.exe" ( set "XELATEX=%MIKTEXBIN%\xelatex.exe" ) else ( set "XELATEX=xelatex" )
if exist "%MIKTEXBIN%\biber.exe"   ( set "BIBER=%MIKTEXBIN%\biber.exe"   ) else ( set "BIBER=biber" )
if exist "%MIKTEXBIN%\bibtex.exe"  ( set "BIBTEX=%MIKTEXBIN%\bibtex.exe" ) else ( set "BIBTEX=bibtex" )

rem ==== CONFIG COMUN ====
set "OUTDIR=build"
set "XFLAGS=-interaction=nonstopmode -shell-escape -output-directory=%OUTDIR%"

if not exist "%OUTDIR%" mkdir "%OUTDIR%"

echo Compilando plantillas sin latexmk...

echo.
echo === Compilando IEEE ===
"%XELATEX%" %XFLAGS% main_ieee.tex
if errorlevel 1 (
    echo Error compilando IEEE - primera pasada
    goto :error
)

"%BIBER%" "%OUTDIR%/main_ieee.bcf"
if errorlevel 1 (
    echo Advertencia: Error con biber IEEE
)

"%XELATEX%" %XFLAGS% main_ieee.tex
if errorlevel 1 (
    echo Error compilando IEEE - segunda pasada
    goto :error
)

echo IEEE compilado exitosamente: %OUTDIR%\main_ieee.pdf

echo.
echo === Compilando ACM ===
"%XELATEX%" %XFLAGS% main_acm.tex
if errorlevel 1 (
    echo Error compilando ACM - primera pasada
    goto :error
)

rem NOTA: Si tu ACM usa biblatex, cambia la línea siguiente a "%BIBER%" "%OUTDIR%/main_acm.bcf"
"%BIBTEX%" "%OUTDIR%/main_acm.aux"
if errorlevel 1 (
    echo Advertencia: Error con bibtex ACM
)

"%XELATEX%" %XFLAGS% main_acm.tex
if errorlevel 1 (
    echo Error compilando ACM - segunda pasada
    goto :error
)

echo ACM compilado exitosamente: %OUTDIR%\main_acm.pdf

echo.
echo === Compilando APA7 ===
"%XELATEX%" %XFLAGS% main_apa7.tex
if errorlevel 1 (
    echo Error compilando APA7 - primera pasada
    goto :error
)

"%BIBER%" "%OUTDIR%/main_apa7.bcf"
if errorlevel 1 (
    echo Advertencia: Error con biber APA7
)

"%XELATEX%" %XFLAGS% main_apa7.tex
if errorlevel 1 (
    echo Error compilando APA7 - segunda pasada
    goto :error
)

echo APA7 compilado exitosamente: %OUTDIR%\main_apa7.pdf

echo.
echo === TODAS LAS PLANTILLAS COMPILADAS EXITOSAMENTE ===
dir "%OUTDIR%\*.pdf"
goto :end

:error
echo.
echo === ERROR EN LA COMPILACION ===
echo Revise los mensajes de error anteriores
exit /b 1

:end
echo.
echo Compilacion completada exitosamente.
exit /b 0
