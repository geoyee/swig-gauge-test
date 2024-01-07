@echo off
for /D %%e in (*) do (
    if %%e == "specs" (
        echo "Skipping specs directory"
    ) else (
        cd %%e
        gauge run
        cd ..
    )
)
