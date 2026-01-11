const API_BASE = "http://localhost:8080/api";

async function apiGet(path) {
  const res = await fetch(`${API_BASE}${path}`);
  if (!res.ok) throw new Error(`GET ${path} -> ${res.status}`);
  return res.json();
}

async function apiPost(path, body) {
  const res = await fetch(`${API_BASE}${path}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  });
  if (!res.ok) {
    const txt = await res.text().catch(() => "");
    throw new Error(`POST ${path} -> ${res.status} ${txt}`);
  }
  return res.json();
}

function show(el, obj) {
  el.textContent = typeof obj === "string" ? obj : JSON.stringify(obj, null, 2);
}

document.getElementById("btnHealth").addEventListener("click", async () => {
  const out = document.getElementById("healthOut");
  try { show(out, await apiGet("/health")); }
  catch (e) { show(out, String(e)); }
});

document.getElementById("btnLoadMembers").addEventListener("click", async () => {
  const out = document.getElementById("membersOut");
  try { show(out, await apiGet("/members")); }
  catch (e) { show(out, String(e)); }
});

document.getElementById("memberForm").addEventListener("submit", async (ev) => {
  ev.preventDefault();
  const out = document.getElementById("memberCreateOut");
  const fd = new FormData(ev.target);
  const body = {
    fullName: fd.get("fullName"),
    email: fd.get("email"),
    joinDate: fd.get("joinDate"),
  };
  try {
    show(out, await apiPost("/members", body));
    ev.target.reset();
  } catch (e) {
    show(out, String(e));
  }
});

document.getElementById("btnLoadFacilities").addEventListener("click", async () => {
  const out = document.getElementById("facilitiesOut");
  try { show(out, await apiGet("/facilities")); }
  catch (e) { show(out, String(e)); }
});

document.getElementById("btnLoadBookings").addEventListener("click", async () => {
  const out = document.getElementById("bookingsOut");
  try { show(out, await apiGet("/bookings")); }
  catch (e) { show(out, String(e)); }
});

document.getElementById("bookingForm").addEventListener("submit", async (ev) => {
  ev.preventDefault();
  const out = document.getElementById("bookingCreateOut");
  const fd = new FormData(ev.target);
  const body = {
    memberId: Number(fd.get("memberId")),
    facilityId: Number(fd.get("facilityId")),
    date: fd.get("date"),
    startTime: fd.get("startTime"),
    endTime: fd.get("endTime"),
  };
  try {
    show(out, await apiPost("/bookings", body));
    ev.target.reset();
  } catch (e) {
    show(out, String(e));
  }
});
